package vice.BFEndCities.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.structures.EndCityPieces;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;

import java.util.List;
import java.util.Random;

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
    @Overwrite()
    public boolean generate(StructureTemplateManager p_71161_, int p_71162_, EndCityPieces.EndCityPiece p_71163_, BlockPos p_71164_, List<StructurePiece> p_71165_, RandomSource p_71166_) {
        if (p_71162_ > 16) {
            return false;
        } else {
            Rotation rotation = p_71163_.placeSettings.getRotation();

            EndCityPieces.EndCityPiece endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, p_71163_, p_71164_, "base_floor", rotation, true));
            int i = p_71166_.nextInt(4);

            if (i == 0)
            {
                //EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 4, -1), "base_roof", rotation, true));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 0, -1), "second_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 8, -1), "second_roof", rotation, false));

                EndCityPieces.recursiveChildren(p_71161_, EndCityPieces.TOWER_GENERATOR, p_71162_ + 1, endcitypieces$endcitypiece, (BlockPos)null, p_71165_, p_71166_);
            }
            else if (i == 1)
            {
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 0, -1), "second_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 4, -1), "third_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 8, -1), "third_roof", rotation, true));

                EndCityPieces.recursiveChildren(p_71161_, EndCityPieces.TOWER_GENERATOR, p_71162_ + 1, endcitypieces$endcitypiece, (BlockPos)null, p_71165_, p_71166_);
            }
            else if (i == 2)
            {
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 0, -1), "second_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 4, -1), "third_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(0, 4, 0), "third_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 8, -1), "third_roof", rotation, true));

                EndCityPieces.recursiveChildren(p_71161_, EndCityPieces.TOWER_GENERATOR, p_71162_ + 1, endcitypieces$endcitypiece, (BlockPos)null, p_71165_, p_71166_);
            }
            else
            {
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 0, -1), "second_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 4, -1), "third_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(1, 4, 1), "second_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 4, -1), "third_floor_2", rotation, false));
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71165_, EndCityPieces.addPiece(p_71161_, endcitypieces$endcitypiece, new BlockPos(-1, 8, -1), "third_roof", rotation, true));

                EndCityPieces.recursiveChildren(p_71161_, EndCityPieces.TOWER_GENERATOR, p_71162_ + 1, endcitypieces$endcitypiece, (BlockPos)null, p_71165_, p_71166_);
            }

            return true;
        }
    }

//    @ModifyConstant(constant = @Constant(intValue = 8, ordinal = 0), method = "generate")
//    public int modifyConstant(int constant) {
//        return 16;
//    }

}