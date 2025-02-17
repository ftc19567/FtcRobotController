package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class roller implements MechanismTemplate{
    Servo rollerServo;
    Telemetry telemetry;
    public roller(HardwareMap hwmap, Telemetry telemetry){
        setMode(hwmap, telemetry);
    }

    @Override
    public void setMode(HardwareMap hwMap, Telemetry telemetry) {
        rollerServo = hwMap.get(Servo.class, "intakeServo");
        this.telemetry = telemetry;
    }

    public void intake(double pos){
        rollerServo.setPosition(pos);
    }

    public void outake(double pos){
        rollerServo.setPosition(pos);
    }

    public void setPosition(int pos){
        rollerServo.setPosition(Range.clip(pos, rollerServo.MIN_POSITION, rollerServo.MAX_POSITION));
    }

    public double getPosition(){
        return rollerServo.getPosition();
    }

    public void setDirection(Servo.Direction direction){
        rollerServo.setDirection(direction);
    }
}
