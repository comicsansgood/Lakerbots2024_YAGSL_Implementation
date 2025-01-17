package frc.robot.commands.FeederCommands;
import frc.robot.subsystems.FeederSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class FeederJoystick extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final FeederSubsystem m_feederSubsystem;
  private XboxController controller;

  public FeederJoystick(FeederSubsystem feeder, XboxController controller) {
    m_feederSubsystem = feeder;
    this.controller = controller;
    addRequirements(m_feederSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    m_feederSubsystem.feederGo(controller.getLeftY()*0.75);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}
