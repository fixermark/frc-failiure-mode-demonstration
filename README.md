# FRC failure mode demonstration

Demonstration of failure modes for FRC programs

## Demonstrable failure modes

* A button: try to set motor speed from two points in code
* B button: simulate a "hit" on the robot, dropping motors 2 and 3 for a moment
* X button: simulate a "brownout"; motors run faster three seconds, then the robot starts to judder
* left and right bumper: try to read a null pointer (crash program) 