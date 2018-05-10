package ch5.num20;

abstract class Shape {
    abstract double area();

}

/**
 * C version union的使用
 * #include "math.h"
 * typedef enum {RECTANGLE, CIRCLE} shapeType_t;
 * <p>
 * typedef struct {
 * double length;
 * double width;
 * } rectangleDimentions_t;
 * <p>
 * typedef struct {
 * double radius;
 * } circleDimentions_t;
 * <p>
 * typedef struct {
 * shapeType_t tag;
 * union {
 * rectangleDimentions_t rectangle;
 * circleDimentions_t circle;
 * } dimentions;
 * } shapt_t;
 * <p>
 * double area(shapt_t *shape) {
 * switch (shape->tag) {
 * case RECTANGLE: {
 * double length = shape->dimentions.rectangle.length;
 * double width = shape->dimentions.rectangle.width;
 * return length * width;
 * }
 * case CIRCLE: {
 * double r = shape->dimentions.circle.radius;
 * return M_PI * (r * r);
 * }
 * default:  {
 * return -1.0;
 * }
 * }
 * }
 */
