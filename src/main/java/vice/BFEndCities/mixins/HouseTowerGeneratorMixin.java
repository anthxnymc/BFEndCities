package vice.BFEndCities.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.structures.EndCityPieces;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;

import java.util.List;
import java.util.Random;
import net.minecraft.util.RandomSource;

// HOUSE_TOWER_GENERATOR
@Pseudo
@Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.EndCityPieces$1")
public class HouseTowerGeneratorMixin
{
//    @Redirect(at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"), method = "generate")
//    public int getCloudHeight(Random instance, int bound)
//    {
//        var ret = instance.nextInt(3);
//        if (ret == 2)
//            return ret;
//
//        if (instance.nextBoolean())
//            return 2;
//
//        return ret;
//    }

    /**
     * @author Team Deus Vult
     */
    @Overwrite
    public boolean generate(StructureTemplateManager p_227517_, int p_227518_, EndCityPieces.EndCityPiece p_227519_, BlockPos p_227520_, List<StructurePiece> p_227521_, RandomSource p_227522_) {
        if (p_227518_ > 16) {
            return false;
        } else {
            Rotation rotation = p_227519_.placeSettings.getRotation();

            EndCityPieces.EndCityPiece endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, p_227519_, p_227520_, "base_floor", rotation, true));
            int i = p_227522_.nextInt(4);

            if (i == 0)
            {
                //EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 4, -1), "base_roof", rotation, true));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 0, -1), "second_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 8, -1), "second_roof", rotation, false));

                EndCityPieces.recursiveChildren(p_227517_, EndCityPieces.TOWER_GENERATOR, p_227518_ + 1, endcitypieces$endcitypiece, (BlockPos)null, p_227521_, p_227522_);
            }
            else if (i == 1)
            {
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 0, -1), "second_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 4, -1), "third_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 8, -1), "third_roof", rotation, true));

                EndCityPieces.recursiveChildren(p_227517_, EndCityPieces.TOWER_GENERATOR, p_227518_ + 1, endcitypieces$endcitypiece, (BlockPos)null, p_227521_, p_227522_);
            }
            else if (i == 2)
            {
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 0, -1), "second_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 4, -1), "third_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(0, 4, 0), "third_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 8, -1), "third_roof", rotation, true));

                EndCityPieces.recursiveChildren(p_227517_, EndCityPieces.TOWER_GENERATOR, p_227518_ + 1, endcitypieces$endcitypiece, (BlockPos)null, p_227521_, p_227522_);
            }
            else
            {
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 0, -1), "second_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 4, -1), "third_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(1, 4, 1), "second_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 4, -1), "third_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-1, 8, -1), "third_roof", rotation, true));

                EndCityPieces.recursiveChildren(p_227517_, EndCityPieces.TOWER_GENERATOR, p_227518_ + 1, endcitypieces$endcitypiece, (BlockPos)null, p_227521_, p_227522_);
            }

            return true;
        }
    }

//    @ModifyConstant(constant = @Constant(intValue = 8, ordinal = 0), method = "generate")
//    public int modifyConstant(int constant) {
//        return 16;
//    }

}