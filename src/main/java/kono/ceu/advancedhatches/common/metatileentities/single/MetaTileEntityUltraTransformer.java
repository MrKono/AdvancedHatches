package kono.ceu.advancedhatches.common.metatileentities.single;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.GTValues;
import gregtech.api.capability.impl.EnergyContainerHandler;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.SimpleOverlayRenderer;
import gregtech.client.utils.PipelineUtil;
import gregtech.common.metatileentities.electric.MetaTileEntityTransformer;
import kono.ceu.advancedhatches.common.metatileentities.AHMetaTileEntities;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.Arrays;

import static gregtech.api.capability.GregtechDataCodes.AMP_INDEX;
import static gregtech.api.capability.GregtechDataCodes.SYNC_TILE_MODE;

public class MetaTileEntityUltraTransformer extends MetaTileEntityTransformer {

    private final int[] highAmp;
    private boolean isTransformUp;
    private int ampIndex;

    public MetaTileEntityUltraTransformer(ResourceLocation metaTileEntityId, int tier, int... highAmp) {
        super(metaTileEntityId, tier);
        if (highAmp == null || highAmp.length == 0) {
            this.highAmp = new int[] { 1 }; // fallback case, "normal" transformer
        } else {
            this.highAmp = highAmp;
        }
        this.ampIndex = this.highAmp.length - 1; // start as max amperage this transformer can do
        reinitializeEnergyContainer();
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityUltraTransformer(metaTileEntityId, getTier(), highAmp);
    }

    @Override
    public boolean hasMultipleAmperages() {
        return highAmp != null && highAmp.length > 1;
    }

    @Override
    public int getCurrentHighAmperage() {
        return highAmp != null ? highAmp[ampIndex] : 4; // funny fallback moment
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setBoolean("Inverted", isTransformUp);
        if (hasMultipleAmperages()) {
            data.setInteger("ampIndex", ampIndex);
        }
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.isTransformUp = data.getBoolean("Inverted");
        if (hasMultipleAmperages()) {
            this.ampIndex = data.getInteger("ampIndex");
        }
        reinitializeEnergyContainer();
    }

    @Override
    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeBoolean(isTransformUp);
        if (hasMultipleAmperages()) {
            buf.writeInt(ampIndex);
        }
    }

    @Override
    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.isTransformUp = buf.readBoolean();
        if (hasMultipleAmperages()) {
            this.ampIndex = buf.readInt();
        }
    }

    @Override
    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == SYNC_TILE_MODE) {
            this.isTransformUp = buf.readBoolean();
            scheduleRenderUpdate();
        } else if (dataId == AMP_INDEX) {
            this.ampIndex = buf.readInt();
            scheduleRenderUpdate();
        }
    }

    @Override
    public void setTransformUp(boolean inverted) {
        isTransformUp = inverted;
        if (!getWorld().isRemote) {
            reinitializeEnergyContainer();
            writeCustomData(SYNC_TILE_MODE, b -> b.writeBoolean(isTransformUp));
            notifyBlockUpdate();
            markDirty();
        }
    }

    @Override
    protected void incrementAmpIndex() {
        if (hasMultipleAmperages()) {
            this.ampIndex++;
            if (this.ampIndex >= highAmp.length) {
                this.ampIndex = 0;
            }
            if (!getWorld().isRemote) {
                reinitializeEnergyContainer();
                writeCustomData(AMP_INDEX, b -> b.writeInt(ampIndex));
                notifyBlockUpdate();
                markDirty();
            }
        }
    }

    @Override
    protected void reinitializeEnergyContainer() {
        long tierVoltage = GTValues.V[getTier()];
        int highAmperage = getCurrentHighAmperage();
        int lowAmperage = highAmperage * 4;

        if (isTransformUp) {
            // storage = 1 amp high; input = tier / 4; amperage = 4; output = tier; amperage = 1
            this.energyContainer = new EnergyContainerHandler(this, tierVoltage * 8L * lowAmperage, tierVoltage,
                    lowAmperage, tierVoltage * 4, highAmperage);
            ((EnergyContainerHandler) this.energyContainer).setSideInputCondition(s -> s != getFrontFacing());
            ((EnergyContainerHandler) this.energyContainer).setSideOutputCondition(s -> s == getFrontFacing());
        } else {
            // storage = 1 amp high; input = tier; amperage = 1; output = tier / 4; amperage = 4
            this.energyContainer = new EnergyContainerHandler(this, tierVoltage * 8L * lowAmperage, tierVoltage * 4,
                    highAmperage, tierVoltage, lowAmperage);
            ((EnergyContainerHandler) this.energyContainer).setSideInputCondition(s -> s == getFrontFacing());
            ((EnergyContainerHandler) this.energyContainer).setSideOutputCondition(s -> s != getFrontFacing());
        }
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        super.renderMetaTileEntity(renderState, translation, pipeline);

        SimpleOverlayRenderer otherFaceTexture;
        SimpleOverlayRenderer frontFaceTexture;

        switch (getCurrentHighAmperage()) {
            case 1 -> { // 1A <-> 4A
                otherFaceTexture = isTransformUp ? Textures.ENERGY_IN : Textures.ENERGY_OUT;
                frontFaceTexture = isTransformUp ? Textures.ENERGY_OUT_MULTI : Textures.ENERGY_IN_MULTI;
            }
            case 2 -> { // 2A <-> 8A
                otherFaceTexture = isTransformUp ? Textures.ENERGY_IN_MULTI : Textures.ENERGY_OUT_MULTI;
                frontFaceTexture = isTransformUp ? Textures.ENERGY_OUT_HI : Textures.ENERGY_IN_HI;
            }
            case 4 -> { // 4A <-> 16A
                otherFaceTexture = isTransformUp ? Textures.ENERGY_IN_HI : Textures.ENERGY_OUT_HI;
                frontFaceTexture = isTransformUp ? Textures.ENERGY_OUT_ULTRA : Textures.ENERGY_IN_ULTRA;
            }
            default -> { // 16A <-> 64A or more
                otherFaceTexture = isTransformUp ? Textures.ENERGY_IN_ULTRA : Textures.ENERGY_OUT_ULTRA;
                frontFaceTexture = isTransformUp ? Textures.ENERGY_OUT_MAX : Textures.ENERGY_IN_MAX;
            }
        }
        frontFaceTexture.renderSided(frontFacing, renderState, translation,
                PipelineUtil.color(pipeline, GTValues.VC[getTier() + 1]));
        Arrays.stream(EnumFacing.values()).filter(f -> f != frontFacing)
                .forEach((f -> otherFaceTexture.renderSided(f, renderState, translation,
                        PipelineUtil.color(pipeline, GTValues.VC[getTier()]))));
    }

    @Override
    public boolean isValidFrontFacing(EnumFacing facing) {
        return true;
    }

    @Override
    public boolean onSoftMalletClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        if (getWorld().isRemote) {
            scheduleRenderUpdate();
            return true;
        }
        if (isTransformUp) {
            setTransformUp(false);
            playerIn.sendMessage(new TextComponentTranslation("gregtech.machine.transformer.message_transform_down",
                    energyContainer.getInputVoltage(), energyContainer.getInputAmperage(),
                    energyContainer.getOutputVoltage(), energyContainer.getOutputAmperage()));
        } else {
            setTransformUp(true);
            playerIn.sendMessage(new TextComponentTranslation("gregtech.machine.transformer.message_transform_up",
                    energyContainer.getInputVoltage(), energyContainer.getInputAmperage(),
                    energyContainer.getOutputVoltage(), energyContainer.getOutputAmperage()));
        }
        return true;
    }

    @Override
    public boolean onScrewdriverClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing,
                                      CuboidRayTraceResult hitResult) {
        if (hasMultipleAmperages()) {
            if (getWorld().isRemote) {
                scheduleRenderUpdate();
                return true;
            }
            incrementAmpIndex();
            playerIn.sendMessage(new TextComponentTranslation("gregtech.machine.transformer_adjustable.message_adjust",
                    energyContainer.getInputVoltage(), energyContainer.getInputAmperage(),
                    energyContainer.getOutputVoltage(), energyContainer.getOutputAmperage()));
            return true;
        }
        return false;
    }

    @Override
    public void getSubItems(CreativeTabs creativeTabs, NonNullList<ItemStack> subItems) {
        if (this == AHMetaTileEntities.ULTRA_HI_AMP_TRANSFORMER[0]) {
            for (MetaTileEntityUltraTransformer transformer : AHMetaTileEntities.ULTRA_HI_AMP_TRANSFORMER) {
                if (transformer != null) subItems.add(transformer.getStackForm());
            }
            for (MetaTileEntityUltraTransformer transformer : AHMetaTileEntities.ULTRA_POWER_TRANSFORMER) {
                if (transformer != null) subItems.add(transformer.getStackForm());
            }
        }
    }
}