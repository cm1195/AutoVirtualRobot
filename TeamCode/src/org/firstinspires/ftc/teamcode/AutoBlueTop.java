package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name="AutoBlueTop", group="FreightBot")
public class AutoBlueTop extends LinearOpMode implements AutoTemplate {
    DcMotor leftMotor, rightMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        leftMotor = hardwareMap.dcMotor.get("back_left_motor");
        rightMotor = hardwareMap.dcMotor.get("back_right_motor");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        turnToCarousel();
        placeFreight();
        goToWarehouse();
    }

    @Override
    public void drive(int leftPos, int rightPos, int power) {
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setTargetPosition(leftPos);
        rightMotor.setTargetPosition(rightPos);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftMotor.setPower(power);
        rightMotor.setPower(power);

        while (leftMotor.isBusy() && rightMotor.isBusy()) {
            idle();
        }

        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    @Override
    public void turnToCarousel() {
        drive(2500, -2125, 1);
        drive(4500, 4500, 1);
    }

    @Override
    public void placeFreight() {

    }

    @Override
    public void goToWarehouse() {
        drive(-4500, -4500, 1);
        drive(-6000, 10000, 1);
        drive(7500, 7500, 1);
    }
}
