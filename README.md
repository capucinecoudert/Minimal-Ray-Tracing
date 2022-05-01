# Minimal-Ray-Tracing

The program contained in this archive computes the image of a scene composed of spheres and lights from a camera position by using a ray tracing algorithm.

// Camera Class
attributes: a double as its focal distance, a Point as the origin of the camera, 
            a Point as the center of the plane of the image; 2 vectors defining the orientation of the plane of the image in space and its size; 2 ints defining the number of pixels of the image
methods: getRay (int, int)

// ColorFloat Class
attributes: 3 doubles parameters defining the red, green, blue components of the color between 0-1.
methods: multiply (ColorFloat); multiply (double); add (ColorFloat); colorToInt ()

// ColorInt Class
attributes: 3 int parameters defining the red, green, blue components of the color between 0-255.
methods: none

// HitResult Class
attributes: a double as a distance, a boolean as an indicator if the ray hhas hitten the object or not
methods: none

// Interface Class   


// InterfaceBasic Class
attributes: two JLabels
methods: none

// InterfaceEdition Class
attributes: several Materials, several JButtons and several JTextField that create the interface, and a Camera and two ArrayList made of Spheres and Lights
methods: actionPerformed (actionEvent); initScene (); displayMessage (String); launchRayRendering (ArrayList<Sphere>, ArrayList<Light>, Camera); verifSaisie (String); verifINT (String); verifDOUBLE(String); comboToMaterial (String); materialToCombo (Material); resetCamera () ; interfaceToCamera (); cameraToInterface (); resetLight (); lightToInterface (int); InterfaceToLight (int); resetSpher (); sphereToInterface (int); interfaceToSphere (int); isCameraValid (); isLightValid(); checkRGBValue(String); isSphereValid (); isSceneValid (); initializeMaterials (); createIHM ()

// Light Class
attributes: a Point of origin, a Color of Intensity
methods: none

// Main Class
launches the interface

// Material Class
attributes: a double as its coefficient of reflection, a double as its specular power, a Color of diffusion
methods: none

// Point Class
attributes: 3 double as position coordinates : x, y, z
methods: add (Vector); substract (Point); distance (Point)

// Ray Class
attributes: a point of Origin, a Vector of direction
methods: distancePoint (Point)

// RayRendering Class
attributes: a Scene, an int defining the maximum number of times a ray can be reflected 
methods: intersectRay (Ray, Scene, int); computeColor (Ray, Scene, Sphere, double, int); hitObject (Ray, Sphere); createImage ()

// Scene Class
attributes: a Camera, a list of Spheres, a list of Lights
methods: none

// Sphere Class
attributes: a radius, a Point as centre, a Material
methods:none

// Vector Class
attributes: 3 double as position coordinates : x, y, z
methods: norm (); normalize (); add (Point); add (Vector); substract (Vector); multiply (double); divide (double); dotProduct (Vector); crossProduct (Vector)


## Class Diagram

```mermaid
classDiagram

    Camera --> Point
    Camera --> Vector

    InterfaceEdition --> Material
    InterfaceEdition --> Camera
    InterfaceEdition --> Sphere
    InterfaceEdition --> Light

    Light --> ColorFloat
    Light --> Point

    Material --> ColorFloat

    Ray --> Point
    Ray --> Vector

    RayRendering --> Scene

    Scene --> Camera
    Scene --> Sphere
    Scene --> Light

    Sphere --> Point
    Sphere --> Material


    class Camera{
        + resolutionX : int
        + resolutionY : int
        + focalDistance : int
        + centreImg : Point
        + originCamera : Point
        + extentX : Vector
        + extentY :  Vector
        Camera (Point c, int d, Vector vX, int rX, Vector vY, int rY)
        getRay (int x, int y) : Ray
    }

    class ColorFloat{
        + red : double
        + blue : double
        + green : double
        ColorFloat (double r, double b, double g)
        multiply (ColorFloat c) : ColorFloat
        multiply (double c) : ColorFloat
        add (ColorFloat c) : ColorFloat
        ColorToInt () : ColorInt
    }

    class ColorInt{
        + red : int
        + blue : int
        + green : int
        ColorInt (int r, int b, int g)
        intToColor() : ColorFloat
    }

    class HitResult{
        + distance : double
        + hit : boolean
        HitResult (double d, boolean h)
    }

    class InterfaceBasic{
        + b : JLabel
        + image : JLabel
        InterfaceBasic ()
    }

    class InterfaceEdition{
        + black : Material
        + white : Material
        + green : Material
        + cyan : Material
        + red : Material
        + magenta : Material
        + yellow : Material
        + blue : Material
        + comboBoxMaterial : JComboBox<String> 

        + c: Camera
        + spheres : ArrayList<Sphere>
        + lights : ArrayList<Light>

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

        + origin1x : JTextField
        + origin1y : JTextField
        + origin1z : JTextField
        + Red1 : JTextField
        + Green1 : JTextField
        + Blue1 : JTextField
        
        + radius 1 :JTextField
        + sphere1x : JTextField
        + sphere1y : JTextField
        + sphere1z : JTextField

        + ValidateCamera : JButton
        + DeleteCamera : JButton
        + ValidateLight1 : JButton
        + DeleteLight : JButton
        + ValidateSphere : JButton
        + DeleteSphere : JButton
        + ValidateScene : JButton

        InterfaceEdition ()
        actionPerformed (ActionEvent e)
        initScene ()
        displayMessage (String s)
        launchRayRendering (ArrayList<Sphere> sp, ArrayList<Light> l, Camera ca)
        verifSaisie (String AVerifier) : boolean
        verifINT (String AVerifier) : boolean
        verifDOUBLE (String AVerifier) : boolean
        comboToMaterial (String selected) : Material
        materialToCombo (material m) : int
        resetCamera ()
        interfaceToCamera
        cameraToInterface ()
        resetLight ()
        lightToInterface (int i)
        interfaceToLight (int j)
        resetSphere ()
        sphereToInterface (int i)
        interfaceToSphere (int i)
        isCameraValid () : boolean
        isLightValid () : boolean
        checkRGBvalue (String s) : boolean
        isSphereValid () : boolean
        isSceneValid () : boolean
        initializeMaterials ()
        createIHM ()
    }

    class Light{
        + intensity : ColorFloat
        + origin : Point
        Light (Point o, ColorFloat i)
    }
    
    class Material{
        + reflectionCoeff : double
        + specularPower : double
        + diffusionColor : ColorFloat
        Material (double r, double p, ColorFloat d)
    }
   
    class Point{
        + x : double
        + y : double
        + z : double
        Point (double x, double y, double z)
        add (Vector v1) : Point
        substract (Point v1) : Point
        distance (Point p) : double
    }
    class Ray{
        + origin : Point
        + direction : Vector
        Ray (Point p, vector v)
        distancePoint (Point p) : double
    }
    class RayRendering{
        + scene : Scene
        + maxReflectionGeneration : int
        intersectRay (Ray ray, Scene scene, int generation) : ColorFloat
        computeColor (Ray ray, Sphere sphere, Scene scene, double distance, int generation) : ColorFloat
        hitObject (Ray ray, Sphere sphere) : HitResult
        createImage ()
    }
    class Scene{
        + camera : Camera
        + spheres : ArrayList<Sphere>
        + lights : ArrayList <Light>
        Scene (ArrayList<Sphere> s, Camera c, ArrayList<Light> l)
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
        norm () : double
        normalize () 
        add (Point p) : Point
        add (Vector v2) : Vector
        substract (Vector v2) : Vector
        multiply (double c) : Vector
        divide (double c) : Vector
        dotProduct (Vector v2) : double
        crossProduct (Vector v2) : Vector
    }
```




