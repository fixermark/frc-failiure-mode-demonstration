package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Motors;

public class FightCommand extends CommandBase {
    private final Motors motors;

    public FightCommand(Motors m) {
        motors = m;
    }

    @Override
    public void execute() {
        /** This may fight because the periodic in the subsystem is trying to set the speed continuously */
        motors.setMotorSpeed(0, 0.5);
    }

    @Override
    public void end(boolean interrupted) {
        motors.setMotorSpeed(0,0);
    }

}
