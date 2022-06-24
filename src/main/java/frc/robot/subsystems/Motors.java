// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motors extends SubsystemBase {

  /** Motor to simulate writing at multiple locations */
  public WPI_VictorSPX driveMotor = new WPI_VictorSPX(1);

  /** Motor to simulate robot taking a hit (turn off when button hit) */
  public WPI_VictorSPX slowSpin = new WPI_VictorSPX(2);

  /** Motor to simulate packet drop (judder motor) */
  public WPI_VictorSPX mediumSpin = new WPI_VictorSPX(3);

  /** Not a real motor; dangling pointer */
  public VictorSPX notARealMotor;

  /** Counter for how long the robot is disrupted by a hit */
  private int hitCounter;

  /** Creates a new Motors subsystem. */
  public Motors() {
    SmartDashboard.putData(driveMotor);
    SmartDashboard.putData(slowSpin);
    SmartDashboard.putData(mediumSpin);
  }

  /**
   * Set speed of motor between 0 and 1
   * 
   * @param whichMotor motor to control (driveMotor, slowSpin, mediumSpin)
   * @param speed      Speed to set
   */
  public void setMotorSpeed(int whichMotor, double speed) {
    switch (whichMotor) {
      case 0:
        driveMotor.set(VictorSPXControlMode.PercentOutput, speed);
        break;
      case 1:
        slowSpin.set(VictorSPXControlMode.PercentOutput, speed);
        break;
      case 2:
        mediumSpin.set(VictorSPXControlMode.PercentOutput, speed);
        break;
      default:
        System.out.println("Unknown motor ID");
        break;
    }
  }

  public void takeHit() {
    hitCounter = 10;
  }

  @Override
  public void periodic() {
    setMotorSpeed(0, 0.2);

    if (hitCounter > 0) {
      hitCounter--;
      setMotorSpeed(1, 0.0);
      setMotorSpeed(2, 0.0);
    } else {
      setMotorSpeed(1, 0.2);
      setMotorSpeed(2, 0.5);
    }
  }
}
