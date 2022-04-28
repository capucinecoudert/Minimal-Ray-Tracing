# Minimal-Ray-Tracing

Compute image of a scene composed of spheres and lights from a camera position.

// Point Class
attributes: 3 double as position coordinates : x, y, z
methods: add(Vector); substract(Point); distance(Point)

// Vector Class
attributes: 3 double as position coordinates : x, y, z
methods: norm(); normalize(); add(Point); add(Vector); substract(Vector); multiply(double); divide(double); 
         dotProduct(Vector); crossProduct(Vector)

// Ray Class
attributes: a point of Origin, a Vector of direction
methods: distancePoint(Point)

// Color Class
attributes: 3 doubles parameters defining the red, green, blue components of the color between 0-1.
methods: multiply(Color); multiply(double); add(Color); colorToInt()

// ColorInt Class
attributes: 3 int parameters defining the red, green, blue components of the color between 0-255.
methods: none

// Light Class
attributes: a Point of origin, a Color of Intensity
methods: none

// Material Class
attributes: a double as its coefficient of reflection, a double as its specular power, a Color of diffusion
methods: none

// Sphere Class
attributes: a radius, a Point as centre, a Material
methods:none

// HitResult Class
attributes: a double as a distance, a boolean as an indicator if the ray hhas hitten the object or not
methods: none

// Camera Class
attributes: a double as its focal distance, a Point as the origin of the camera, 
            a Point as the center of the plane of the image; 2 vectors defining the orientation of the plane of the image in space and its size; 2 ints defining the number of pixels of the image
methods: getRay(int, int)

// Scene Class
attributes: a Camera, a list of Spheres, a list of Lights
methods: none

// RayRendering Class
attributes: a Scene, an int defining the maximum number of times a ray can be reflected 
methods: intersectRay(Ray, Scene, int); computeColor(Ray, Scene, Sphere, double, int); hitObject(Ray, Sphere); createImage()

// Interface Class
attributes: several Materials, several JButtons and several JTextField that create the interface
methods: actionPerformed(actionEvent);


// Main Class
launches the interface



## Class Diagram

```mermaid
classDiagram
    class Camera{
        + resolutionX : int
        + resolutionY : int
        + focalDistance : int
        + centreImg : Point
        + originCamera : Point
        + extentX : Vector
        + extentY :  Vector
        Camera (Point c, int d, Vector vX, int rX, Vector vY, int rY)
        computeRay (double percentX, double percentY) Ray
    }
    class ColorInt{
        + red : int
        + blue : int
        + green : int
        Color (int r, int b, int g)
    }
    class Color{
        + red : double
        + blue : double
        + green : double
        Color (double r, double b, double g)
        ColorToInt () : ColorInt
    }
    class HitResult{
        + distance : double
        + hit : boolean
        HitResult (double d, boolean h)
    }
    class Interface{
        + Jresolutionx : JTextField
        + Jresolutiony : JTextField
        + JfocalDistance : JTextField  
        + JcentreImgX : JTextField
        + JcentreImgY : JTextField  
        + JcentreImgZ : JTextField  
        + JextentXx : JTextField
        + JextentXy : JTextField  
        + JextentXz : JTextField
        + JextentYx : JTextField
        + JextentYy : JTextField
        + JextentYz : JTextField
        + ValidateCamera : JButton
        Interface()
    }
    class Light{
        + intensity : Color
        + origin : Point
        Light(Point o, Color i)
    }
    class Material{
        + reflectionCoeff : double
        + specularPower : double
        + specularColor : Color
        + diffusionColor : Color
        Material (double r, double p, Color s, Color d)
    }
    class Point{
        + x : double
        + y : double
        + z : double
        Point (double x, double y, double z)
        add (Vector v1) : Point
        distance (Point p) : double
    }
    class Ray{
        + origin : Point
        + direction : Vector
        Ray (Point p, vector v)
    }
    class RayRendering{
        + scene : Scene
        + camera : Camera
        main () 
        computeColor (Ray ray, Scene scene) : Color
        hitObject (Ray ray, Sphere sphere, double distance) : HitResult
        createImage (Scene scene)
    }
    class Scene{
        + camera : Camera
        + spheres : ArrayList<Sphere>
        + lights : ArrayList <Light>
        Scene (ArrayList<Sphere> s, Camera c, ArrayList<Light> 1)
    }
    class Sphere{
        + center : Point
        + radius : double
        + material : Material
        Sphere (Point c, double r, Material m)
    }
    class Vector{
        + x : double
        + y : double
        + z : double
        Vector (double x, double y, double x)
        Vector (Point p1, Point p2)
        norm() : double
        normalize() 
        add(Point p) : Point
        add(Vector v1, Vector v2) : Vector
        substract(Vector v2) : Vector
        multiply(double c) : Vector
        divide(double c) : Vector
        dotProduct(Vector v2) : double
        crossProduct(Vector v2) : Vector
    }
```




