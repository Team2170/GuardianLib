/* Copyright (c) 2025 Galvanized Guardians. All rights reserved. */
/* This work is licensed under the terms of the MIT license */
/* found in the root directory of this project. */

package com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers.Utility;

import com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers.CANdleWrapper.CANdleState;
import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.ColorFlowAnimation;
import com.ctre.phoenix.led.FireAnimation;
import com.ctre.phoenix.led.LarsonAnimation;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.RgbFadeAnimation;
import com.ctre.phoenix.led.SingleFadeAnimation;
import com.ctre.phoenix.led.StrobeAnimation;
import com.ctre.phoenix.led.TwinkleAnimation;
import com.ctre.phoenix.led.TwinkleOffAnimation;

public class CTREBuiltInAnimations {
    public ColorFlowAnimation COLORFLOW;
    public FireAnimation FIRE;
    public LarsonAnimation LARSON;
    public RainbowAnimation RAINBOW;
    public RgbFadeAnimation RGBFADE;
    public SingleFadeAnimation SINGLEFADE;
    public StrobeAnimation STROBE;
    public TwinkleAnimation TWINKLE;
    public TwinkleOffAnimation TWINKLEOFF;

    /**
     * Instantiates built in animations from CTRE that can be used instead of creating custom
     * animations for {@link
     * com.GalvanizedGuardians.GuardianLib.Hardware.LEDControllers.CANdleWrapper#setStateAnimation(CANdleState,
     * Animation) setStateAnimation(CANdleState, Animation)}.
     *
     * @param r How much red should the color have [0, 255].
     * @param g How much green should the color have [0, 255].
     * @param b How much blue should the color have [0, 255].
     */
    public CTREBuiltInAnimations(int r, int g, int b) {
        COLORFLOW = new ColorFlowAnimation(r, g, b);
        FIRE = new FireAnimation();
        LARSON = new LarsonAnimation(r, g, b);
        RAINBOW = new RainbowAnimation();
        RGBFADE = new RgbFadeAnimation();
        SINGLEFADE = new SingleFadeAnimation(r, g, b);
        STROBE = new StrobeAnimation(r, g, b);
        TWINKLE = new TwinkleAnimation(r, g, b);
        TWINKLEOFF = new TwinkleOffAnimation(r, g, b);
    }
}
