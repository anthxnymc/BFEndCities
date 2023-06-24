package vice.BFEndCities.mixins;

import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;


// Fat Tower
@Mixin(targets = "net.minecraft.world.level.levelgen.structure.structures.EndCityPieces$4")
public class EndCityTowerMixin
{
    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/util/RandomSource;nextInt(I)I"), method = "generate")
    public int getCloudHeight(RandomSource instance, int bound)
    {
        return instance.nextInt(8);
    }


    @ModifyConstant(constant = @Constant(intValue = 2), method = "generate")
    public int modifyConstant(int constant) {
        return 8;
    }

}