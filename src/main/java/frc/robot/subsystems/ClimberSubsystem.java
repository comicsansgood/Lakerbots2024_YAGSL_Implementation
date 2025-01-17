package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkBase.SoftLimitDirection;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase{

    public CANSparkFlex climberMotor;
    public SparkPIDController climberPidController;
    public SparkPIDController climberNewPid;

    public double tolerence;
    public double target;
    public double newTarget;

    public ClimberSubsystem(){
        climberMotor = new CANSparkFlex(15, MotorType.kBrushless);
        climberMotor.setIdleMode(IdleMode.kBrake);
        climberMotor.setSoftLimit(SoftLimitDirection.kReverse, 0);
        climberMotor.setSoftLimit(SoftLimitDirection.kForward, -10);
        
        tolerence = Constants.ClimberConstants.climberTolerence;
        climberMotor.getEncoder().setPosition(0);

        climberNewPid = climberMotor.getPIDController();
        climberNewPid.setP(0.0001);
    }

    public double climberGetPosition(){
        return climberMotor.getEncoder().getPosition();
    }

    public boolean climberAtTargetPosition(){
        return Math.abs(target - climberGetPosition()) < tolerence;
    }

    public void climberSpin(double speed){
        climberMotor.set(speed);
    }
    
    public double climberGetCurrent(){
        return climberMotor.getOutputCurrent();
    }

    public void climberSetTarget(double reference){
        newTarget = reference;
        climberNewPid.setReference(newTarget, ControlType.kPosition);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("climber position", climberGetPosition());
        SmartDashboard.putNumber("climber current", climberGetCurrent());
    }
}
