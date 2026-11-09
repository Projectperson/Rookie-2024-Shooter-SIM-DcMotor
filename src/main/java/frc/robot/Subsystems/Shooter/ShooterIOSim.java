package frc.robot.Subsystems.Shooter;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class ShooterIOSim implements ShooterIO {
    private final DCMotorSim motorSim = new DCMotorSim(LinearSystemId.createDCMotorSystem(DCMotor.getNEO(1), 0.04, 1.0),
            DCMotor.getNEO(1));
    private final PIDController controller = new PIDController(0.055, 0.0, 0.0);
    public double volts = 0.0;
    private double setpoint = 0.0;
    boolean isPID = false;

    @Override
    public void updateInputs(shooterInputs inputs) {
        motorSim.update(0.2);

        if (isPID) {
            volts = controller.calculate(motorSim.getAngularVelocityRPM());
            motorSim.setInputVoltage(volts);
        } else{
            motorSim.setInputVoltage(volts);
        }
        inputs.velocity = motorSim.getAngularVelocityRPM();
        inputs.current = motorSim.getCurrentDrawAmps();
        inputs.position = motorSim.getAngularPositionRotations();
        inputs.setpoint = controller.getSetpoint();
        inputs.voltage = volts;
    }

    @Override
    public void setVoltage(double volts) {
        isPID = false;
        this.volts = volts;
    }

    @Override
    public void setVelocity(double velocity) {
        isPID = true;
        this.setpoint = velocity;
        controller.setSetpoint(setpoint);

    }
}
