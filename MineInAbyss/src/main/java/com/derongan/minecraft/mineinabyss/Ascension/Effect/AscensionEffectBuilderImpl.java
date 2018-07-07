package com.derongan.minecraft.mineinabyss.Ascension.Effect;

import com.derongan.minecraft.mineinabyss.Ascension.Effect.Effects.*;
import com.derongan.minecraft.mineinabyss.AbyssContext;
import org.bukkit.Sound;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//TODO look at java patterns and figure out a nice way to not have to repeat the builder multiple times
public abstract class AscensionEffectBuilderImpl<E extends AscensionEffect> implements AscensionEffectBuilder {
    private int offset = 0;
    private int strength = 1;
    private int duration = 200;   // Pass it in as as ticks here
    private int iterations = 1;

    int getOffset() {
        return offset;
    }

    int getStrength() {
        return strength;
    }

    int getIterations(){
        return iterations;
    }

    public AscensionEffectBuilderImpl<E> setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public AscensionEffectBuilderImpl<E> setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    int getDuration() {
        return duration;
    }

    public AscensionEffectBuilderImpl<E> setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public AscensionEffectBuilderImpl<E> setIterations(int iterations) {
        this.iterations = iterations;
        return this;
    }

    public static class BloodyAscensionEffectBuilder extends AscensionEffectBuilderImpl {
        @Override
        public AscensionEffect build() {
            return new BloodyAscensionEffect(getOffset(), getStrength(), getDuration(), getIterations());
        }
    }

    public static class DamagingAscensionEffectBuilder extends AscensionEffectBuilderImpl<DamagingAscensionEffect> {
        @Override
        public DamagingAscensionEffect build() {
            return new DamagingAscensionEffect(getOffset(), getStrength(), getDuration(), getIterations());
        }
    }

    public static class DizzyAscensionEffectBuilder extends AscensionEffectBuilderImpl<DizzyAscensionEffect> {
        @Override
        public DizzyAscensionEffect build() {
            return new DizzyAscensionEffect(getOffset(), getStrength(), getDuration(), getIterations());
        }
    }

    public static class DeathAscensionEffectBuilder extends AscensionEffectBuilderImpl<DeathAscensionEffect> {
        @Override
        public DeathAscensionEffect build() {
            return new DeathAscensionEffect(getOffset(), getStrength(), getDuration(), getIterations());
        }
    }

    public static class
    HallucinatingAscensionEffectBuilder extends AscensionEffectBuilderImpl<HallucinatingAscensionEffect> {
        @Override
        public HallucinatingAscensionEffect build() {
            return new HallucinatingAscensionEffect(getOffset(), getStrength(), getDuration(), getIterations());
        }
    }

    public static class SoundAscensionEffectBuilder extends AscensionEffectBuilderImpl<SoundAscensionEffect> {
        private static final List<String> ALL_SOUNDS = Arrays.stream(Sound.values()).map(sound->sound.name()).collect(Collectors.toList());
        List<String> sounds = ALL_SOUNDS;

        @Override
        public SoundAscensionEffect build() {
            return new SoundAscensionEffect(getOffset(), getStrength(), getDuration(), getIterations(), getSounds());
        }

        public SoundAscensionEffectBuilder setSounds(List<String> allowedSounds){
            sounds = allowedSounds;
            return this;
        }

        List<String> getSounds() {
            return sounds;
        }
    }
}
