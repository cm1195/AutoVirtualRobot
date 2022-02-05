package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Robot Main Code")
public class DriverDemo extends OpMode {

    Servo handServo;
    DcMotor arm, duck;
    DcMotor leftMotor;
    DcMotor rightMotor;

    @Override
    public void init() {
        handServo = hardwareMap.servo.get("hand_servo");
        leftMotor = hardwareMap.dcMotor.get("back_left_motor");
        rightMotor = hardwareMap.dcMotor.get("back_right_motor");
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        arm = hardwareMap.get(DcMotor.class, "arm_motor");
        duck = hardwareMap.get(DcMotor.class, "rotor_motor");
    }

    @Override
    public void loop() /*throws InterruptedException*/ {

        // With these controls, The right and left motors are independently controlled by each joystick:
        double px = gamepad1.right_stick_y;
        double py = gamepad1.left_stick_y;
        double p1 = py;
        double p2 = px;
        double max = Math.max(1.0, Math.abs(p1));
        max = Math.max(max, Math.abs(p2));
        p1 /= max;
        p2 /= max;
        leftMotor.setPower(p1);
        rightMotor.setPower(p2);

        //This controls the arm:
        arm.setPower(-gamepad2.right_stick_y);

        if (gamepad1.x) handServo.setPosition(1);
        else if (gamepad1.y) handServo.setPosition(0);

        //This controls the duck spinner:
        //Counter-Clockwise
        /*if (gamepad1.a) {
            //telemetry.addData("x pressed", "");
            duck.setPower(1);
        //Clockwise:
        } else if (gamepad1.b) {
            //telemetry.addData("b pressed", "");
            duck.setPower(-1);
        } else {
            duck.setPower(0);*/
    }

}
