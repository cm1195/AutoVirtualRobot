package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name="AutoBlueBottom", group = "FreightBot")
public class AutoBlueBottom extends LinearOpMode implements AutoTemplate {
    DcMotor leftMotor, rightMotor;
// 4125

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

    public void turnToCarousel() {
        drive(-2125, 3000, 1); // Turn to Carousel
        drive(4500, 4500, 1); // Drive to Carousel
    }

    @Override
    public void placeFreight() {

    }

    @Override
    public void goToWarehouse() {
        drive(-6000, -6000, 1); // Drive away from carousel
        drive(-2500, 2125, 1); // Turn to warehouse
        drive(20000, 20000, 1); // Drive to warehouse
    }

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
}
