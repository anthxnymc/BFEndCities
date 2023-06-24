package vice.BFEndCities.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.structures.EndCityPieces;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Random;


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
    public boolean generate(StructureTemplateManager p_71180_, int p_71181_, EndCityPieces.EndCityPiece p_71182_, BlockPos p_71183_, List<StructurePiece> p_71184_, RandomSource p_71185_) {
        Rotation rotation = p_71182_.placeSettings.getRotation();

        int i = p_71185_.nextInt(4) + 1;
        i += Math.max(0, (6 - (p_71181_ / 2)));

        EndCityPieces.EndCityPiece endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71184_, EndCityPieces.addPiece(p_71180_, p_71182_, new BlockPos(0, 0, -4), "bridge_piece", rotation, true));
        endcitypieces$endcitypiece.genDepth = -1;
        int j = 0;

        for(int k = 0; k < i; ++k) {
            if (p_71185_.nextBoolean()) {
                endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71184_, EndCityPieces.addPiece(p_71180_, endcitypieces$endcitypiece, new BlockPos(0, j, -4), "bridge_piece", rotation, true));
                j = 0;
            } else {
                if (p_71185_.nextBoolean()) {
                    endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71184_, EndCityPieces.addPiece(p_71180_, endcitypieces$endcitypiece, new BlockPos(0, j, -4), "bridge_steep_stairs", rotation, true));
                } else {
                    endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71184_, EndCityPieces.addPiece(p_71180_, endcitypieces$endcitypiece, new BlockPos(0, j, -8), "bridge_gentle_stairs", rotation, true));
                }

                j = 4;
            }
        }

        if (shipsCreated <= 3 && p_71185_.nextInt(7) == 0)
        {
            shipCreated = false;
            shipsCreated++;
        }

        if (!shipCreated && p_71185_.nextInt(6 - Math.min(5, p_71181_)) == 0) {
            EndCityPieces.addHelper(p_71184_, EndCityPieces.addPiece(p_71180_, endcitypieces$endcitypiece, new BlockPos(-8 + p_71185_.nextInt(8), j, -70 + p_71185_.nextInt(10)), "ship", rotation, true));
            this.shipCreated = true;
            shipsCreated++;

        } else if (!EndCityPieces.recursiveChildren(p_71180_, EndCityPieces.HOUSE_TOWER_GENERATOR, p_71181_ + 1, endcitypieces$endcitypiece, new BlockPos(-3, j + 1, -11), p_71184_, p_71185_)) {
            return false;
        }

        endcitypieces$endcitypiece = EndCityPieces.addHelper(p_71184_, EndCityPieces.addPiece(p_71180_, endcitypieces$endcitypiece, new BlockPos(4, j, 0), "bridge_end", rotation.getRotated(Rotation.CLOCKWISE_180), true));
        endcitypieces$endcitypiece.genDepth = -1;
        return true;
    }


}