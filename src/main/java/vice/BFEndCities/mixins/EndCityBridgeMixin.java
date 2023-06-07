package vice.BFEndCities.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.structures.EndCityPieces;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Random;
import net.minecraft.util.RandomSource;


// BRIDGE
@Pseudo
@Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.EndCityPieces$3")
public class EndCityBridgeMixin
{
    @Shadow public boolean shipCreated;


    public int shipsCreated;

    /**
     * @author Team Deus Vult
     */
    @Overwrite
    public boolean
    generate(StructureTemplateManager p_227517_, int p_227518_, EndCityPieces.EndCityPiece p_227519_, BlockPos p_227520_, List<StructurePiece> p_227521_, RandomSource p_227522_) {

        Rotation rotation = p_227519_.placeSettings.getRotation();

        int i = p_227522_.nextInt(4) + 1;
        i += Math.max(0, (6 - (p_227518_ / 2)));

        EndCityPieces.EndCityPiece endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, p_227519_, new BlockPos(0, 0, -4), "bridge_piece", rotation, true));
        endcitypieces$endcitypiece.genDepth = -1;
        int j = 0;

        for(int k = 0; k < i; ++k) {
            if (p_227522_.nextBoolean()) {
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(0, j, -4), "bridge_piece", rotation, true));
                j = 0;
            } else {
                if (p_227522_.nextBoolean()) {
                    endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(0, j, -4), "bridge_steep_stairs", rotation, true));
                } else {
                    endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(0, j, -8), "bridge_gentle_stairs", rotation, true));
                }

                j = 4;
            }
        }

        if (shipsCreated <= 3 && p_227522_.nextInt(7) == 0)
        {
            shipCreated = false;
            shipsCreated++;
        }

        if (!shipCreated && p_227522_.nextInt(6 - Math.min(5, p_227518_)) == 0) {
            EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(-8 + p_227522_.nextInt(8), j, -70 + p_227522_.nextInt(10)), "ship", rotation, true));
            this.shipCreated = true;
            shipsCreated++;

        } else if (!EndCityPieces.recursiveChildren(p_227517_, EndCityPieces.HOUSE_TOWER_GENERATOR, p_227518_ + 1, endcitypieces$endcitypiece, new BlockPos(-3, j + 1, -11), p_227521_, p_227522_)) {
            return false;
        }

        endcitypieces$endcitypiece = EndCityPieces.addHelper(p_227521_, EndCityPieces.addPiece(p_227517_, endcitypieces$endcitypiece, new BlockPos(4, j, 0), "bridge_end", rotation.getRotated(Rotation.CLOCKWISE_180), true));
        endcitypieces$endcitypiece.genDepth = -1;
        return true;
    }


}