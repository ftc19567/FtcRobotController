package org.firstinspires.ftc.teamcode.mechanisms;

import static org.firstinspires.ftc.teamcode.util.UtilConstants.clawIntakePos;
import static org.firstinspires.ftc.teamcode.util.UtilConstants.clawOutakePos;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Claw implements MechanismTemplate{
    Servo clawServo;
    public Claw(HardwareMap hardwareMap, Telemetry telemetry)
    {
        setMode(hardwareMap, telemetry);
    }
    @Override
    public void setMode(HardwareMap hwMap, Telemetry telemetry) {
        clawServo = hwMap.get(Servo.class, "clawServo");
    }

    public void position(double pos){
        clawServo.setPosition(Range.clip(pos,clawServo.MIN_POSITION,clawServo.MAX_POSITION));
    }

    public double getPos(){
        return clawServo.getPosition();
    }

    public int portNum(){
        return clawServo.getPortNumber();
    }
}