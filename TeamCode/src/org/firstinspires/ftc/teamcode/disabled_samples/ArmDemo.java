package org.firstinspires.ftc.teamcode.disabled_samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
@Autonomous(name="ArmDemo", group = "FreightBot")
public class ArmDemo extends LinearOpMode {
    // Initialize arm motor variable
    DcMotor armMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        // Set arm motor variable
        armMotor = hardwareMap.dcMotor.get("arm_motor");
        // Move the arm motor up 5000 ticks (the arm will move a tiny bit up 5000 times)
        armMotor.setTargetPosition(5000);
        // Turn on motor
        armMotor.setPower(1);

        // Set the robot idle while the motor is moving up
        while (armMotor.isBusy()) {
            idle();
        }

        // Move the arm motor down 5000 ticks (the arm will move a tiny bit down 5000 times)
        armMotor.setTargetPosition(-5000);

        // Set the robot idle while the motor is moving down
        while (armMotor.isBusy()) {
            idle();
        }

        // Turn off the motor
         armMotor.setPower(0);
    }
}
