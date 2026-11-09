package frc.robot.Subsystems.Shooter;
import static edu.wpi.first.units.Units.RPM;
import static edu.wpi.first.units.Units.RadiansPerSecond;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{
    private final ShooterIO io;
    shooterInputsAutoLogged inputs = new shooterInputsAutoLogged();
    public Shooter(ShooterIO io){
        this.io = io;
    }

    @Override
    public void periodic(){
        io.updateInputs(inputs);
        Logger.processInputs("Shooter", inputs);
    }
    
    public void setVoltage(double voltage){
        io.setVoltage(voltage);
    }

    public void setVelocity(double velocity){
        io.setVelocity(velocity);
    }

    public Command stopCommand(){
        return this.runOnce(()->io.setVoltage(0.0));
    }

    public Command runIntake(){
        return this.runOnce(()->io.setVoltage(-3.0));
    }

    public Command shoot(){
        return this.runOnce(()->io.setVelocity(RadiansPerSecond.of(200).in(RPM)));
    }
}
