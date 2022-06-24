package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class NullPointerCommand extends CommandBase {
    private final RobotContainer container;

    public NullPointerCommand(RobotContainer c) {
        container = c;
    }

    @Override
    public void initialize() {
        container.motors.notARealMotor.set(VictorSPXControlMode.PercentOutput, .5);
    }

    @Override
    public void execute() {
        System.out.println("Go");
    }
    

}
