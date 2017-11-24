package com.yann.advance.welcome.view;

import android.animation.TypeEvaluator;

/**
 * Created by yayun.xia on 2017/10/16.
 */

public class LineEvaluator implements TypeEvaluator<Particle> {

    @Override
    public Particle evaluate(float fraction, Particle startValue, Particle endValue) {
        Particle particle = new Particle();
        particle.x = startValue.x + (endValue.x - startValue.x) * fraction;
        particle.y = startValue.y + (endValue.y - startValue.y) * fraction;
        particle.radius = startValue.radius + (endValue.radius - startValue.radius) * fraction;
        return particle;
    }
}
