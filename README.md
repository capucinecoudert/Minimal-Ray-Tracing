# Minimal-Ray-Tracing

Compute image of a scene composed of Spheres.

## Class Diagram




```mermaid
classDiagram
    class Point{
        + x : double
        + y : double
        + z : double
    }
    class Vector{
        + x : double
        + y : double
        + z : double
    }
    class Camera{
        + resolutionX : int
        + resolutionY : int
        + focalDistance : int
        + centreImg : Point
        + originCamera : Point
        + extentX : Vector
        + extentY :  Vector

        

    }

