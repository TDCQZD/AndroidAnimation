package com.example.administrator.androidanimation.View;

import android.animation.TypeEvaluator;

import com.example.administrator.androidanimation.bean.Point;

/**
 * 自定义TypeEvaluator
 *
 * @author ZD
 *         created at 2017/7/28 18:23
 *         description：
 */

public class PointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        Point point = new Point(x, y);
        return point;
    }
}
