package vice.BFEndCities.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.structures.EndCityPieces;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;
import java.util.Random;
import net.minecraft.util.RandomSource;

//TOWER_GENERATOR
@Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.EndCityPieces$2")
public class EndCityPiecesMixin
{

    @Redirect(at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I", ordinal = 3), method = "generate")
    public int getCloudHeight(Random instance, int bound)
    {
        return instance.nextInt(bound + 2);
    }

    /**
     * @author Team Deus Vult
     */
    @Overwrite()
    public boolean generate(StructureTemplateManager p_227517_, int p_227518_, EndCityPieces.EndCityPiece p_227519_, BlockPos p_227520_, List<StructurePiece> p_227521_, RandomSource p_227522_) {
        Rotation rotation = p_227519_.placeSettings.getRotation();
        EndCityPieces.EndCityPiece $$7 = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, p_227519_, new BlockPos(3 + p_227522_.nextInt(2), -3, 3 + p_227522_.nextInt(2)), "tower_base", rotation, true));
        $$7 = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, $$7, new BlockPos(0, 7, 0), "tower_piece", rotation, true));
        EndCityPieces.EndCityPiece endcitypieces$endcitypiece1 = p_227522_.nextInt(6) == 0 ? $$7 : null;
        int i = 1 + p_227522_.nextInt(3);

        for(int j = 0; j < i; ++j) {
            $$7 = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, $$7, new BlockPos(0, 4, 0), "tower_piece", rotation, true));
            if (j < i - 1 && p_227522_.nextInt(3) == 0) {
                endcitypieces$endcitypiece1 = $$7;
            }
        }

        if (endcitypieces$endcitypiece1 != null) {
            for(Tuple<Rotation, BlockPos> tuple : EndCityPieces.TOWER_BRIDGES) {
                if (p_227522_.nextBoolean()) {
                    EndCityPieces.EndCityPiece endcitypieces$endcitypiece2 = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece1, tuple.getB(), "bridge_end", rotation.getRotated(tuple.getA()), true));
                    EndCityPieces.recursiveChildren(p_227517_, EndCityPieces.TOWER_BRIDGE_GENERATOR, p_227518_ + 1, endcitypieces$endcitypiece2, (BlockPos)null, p_227521_, p_227522_);
                }
            }

            EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, $$7, new BlockPos(-1, 4, -1), "tower_top", rotation, true));
        } else {
            if (p_227518_ < 15) {
                return EndCityPieces.recursiveChildren(p_227517_, EndCityPieces.FAT_TOWER_GENERATOR, p_227518_ + 1, $$7, (BlockPos)null, p_227521_, p_227522_);
            }

            EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, $$7, new BlockPos(-1, 4, -1), "tower_top", rotation, true));
        }

        return true;
    }
}
