package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Motors;

public class BrownoutDemo extends CommandBase {
    private static final double SPEED = 0.25;
    private static final double PAUSE1 = 0.2;
    private static final double PAUSE2 = 0.5;
    private static final double PAUSE3 = 0.1;
    private double brownoutTime;
    private Motors motors;
    private int state = 0;

    public BrownoutDemo(Motors m) {
        motors = m;
    }

    @Override
    public void initialize() {
        brownoutTime = Timer.getFPGATimestamp() + 3;
        state = 0;
    }

    @Override
    public void execute() {
        switch (state) {
            case 0: // high-speed
                setMotors(SPEED);
                if (Timer.getFPGATimestamp() > brownoutTime) {
                    state = 1;
                    brownoutTime = Timer.getFPGATimestamp() + PAUSE1;
                }
                break;
            case 1: // brownout
                setMotors(0);
                if (Timer.getFPGATimestamp() > brownoutTime) {
                    state = 2;
                    brownoutTime = Timer.getFPGATimestamp() + PAUSE1;
                }
                break;
            case 2: // go
                setMotors(SPEED);
                if (Timer.getFPGATimestamp() > brownoutTime) {
                    state = 3;
                    brownoutTime = Timer.getFPGATimestamp() + PAUSE2;
                }
                break;
            case 3: // brownout
                setMotors(0);
                if (Timer.getFPGATimestamp() > brownoutTime) {
                    state = 4;
                    brownoutTime = Timer.getFPGATimestamp() + PAUSE3;
                }
                break;
            case 4: // go
                setMotors(SPEED);
                if (Timer.getFPGATimestamp() > brownoutTime) {
                    state = 1;
                    brownoutTime = Timer.getFPGATimestamp() + PAUSE2;
                }
                break;
        }
    }

    private void setMotors(double speed) {
        motors.setMotorSpeed(0, speed);
        motors.setMotorSpeed(1, speed);
        motors.setMotorSpeed(2, speed);
    }

}
