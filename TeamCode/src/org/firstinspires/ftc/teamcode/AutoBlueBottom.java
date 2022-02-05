package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Disabled()
@Autonomous(name="AutoBlueBottom", group = "FreightBot")
public class AutoBlueBottom extends LinearOpMode implements AutoTemplate {
    DcMotor backLeft, backRight, frontLeft, frontRight;
// 4125

    @Override
    public void runOpMode() throws InterruptedException {
        backLeft = hardwareMap.dcMotor.get("back_left_motor");
        backRight = hardwareMap.dcMotor.get("back_right_motor");
        frontLeft = hardwareMap.dcMotor.get("front_left_motor");
        frontRight = hardwareMap.dcMotor.get("front_right_motor");

        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        turnToCarousel();
        placeFreight();
        goToWarehouse();
    }

    public void turnToCarousel() {
        // Move away from the back wall
        drive(500, 500, 500, 500, 1);
        // Turn Left
        drive(-2500, 2000, -2500, 2000, 1);
        // Drive to the same row as the carousel
        drive(2500, 2500, 2500, 2500, 1);
        // Turn to carousel
        drive(2500, -2000, 2500, -2000, 1);
        // Drive to carousel
        drive(1000, 1000, 1000, 1000, 1);
    }

    @Override
    public void placeFreight() {

    }

    @Override
    public void goToWarehouse() {
        // Turn to warehouse
        drive(2500, -2000, 2500, -2000, 1);
        // Drive to warehouse
        drive(4000, 4000, 4000, 4000, 1);
        // Turn Right
        drive(-2500, 2000, -2500, 2000, 1);
        // Park in the warehouse
        drive(1500, 1500, 1500, 1500, 1);
        drive(-2500, 2000, -2500, 2000, 1);
    }

    @Override
    public void drive(int backLeftPos, int backRightPos, int frontLeftPos, int frontRightPos, double power) {
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        backLeft.setTargetPosition(backLeftPos);
        backRight.setTargetPosition(backRightPos);
        frontLeft.setTargetPosition(frontLeftPos);
        frontRight.setTargetPosition(frontRightPos);

        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        backLeft.setPower(power);
        backRight.setPower(power);
        frontLeft.setPower(power);
        frontRight.setPower(power);

        while (backLeft.isBusy() && backRight.isBusy() && opModeIsActive()) {
            idle();
        }

        backLeft.setPower(0);
        backRight.setPower(0);
        frontLeft.setPower(0);
        frontRight.setPower(0);

        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}
