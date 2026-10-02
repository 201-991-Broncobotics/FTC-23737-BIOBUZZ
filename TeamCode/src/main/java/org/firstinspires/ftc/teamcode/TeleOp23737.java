package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "23737")
public class TeleOp23737 extends LinearOpMode {
  double vertical, horizontal, rotate, sin, cos, max, theta, power ;

    public DcMotor FLMotor, FRMotor, BLMotor, BRMotor;

public void runOpMode() throws InterruptedException {

    FLMotor = hardwareMap.get(DcMotor.class, "FrontLeft");
    FRMotor = hardwareMap.get(DcMotor.class, "FrontRight");
    BLMotor = hardwareMap.get(DcMotor.class, "BackLeft");
    BRMotor = hardwareMap.get(DcMotor.class, "BackRight");

    FLMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    FRMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    BRMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    BLMotor.setDirection(DcMotorSimple.Direction.FORWARD);

    FLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    FRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    BLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    BRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



    waitForStart();

    while (opModeIsActive()) {

        vertical = gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        sin = Math.sin(theta - Math.PI/4);
        cos = Math.cos(theta - Math.PI/4);
        max = Math.max(Math.abs(sin), Math.abs(cos));
        theta = Math.atan2(vertical, horizontal);
        power = Math.hypot(horizontal, vertical);


        FLMotor.setPower(power * cos/max + rotate);
        FRMotor.setPower(power * sin/max - rotate);
        BLMotor.setPower(power * sin/max + rotate);
        BRMotor.setPower(power * cos/max - rotate);

        if ((power + Math.abs(rotate)) > 1) {
            BLMotor.setPower( power + rotate);
            BRMotor.setPower( power + rotate);
            FLMotor.setPower( power + rotate);
            FRMotor.setPower( power + rotate);

        }





        /* This is the first one for the mecanum drive, it's the most simple
        vertical = gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        FRMotor.setPower(horizontal - vertical - rotate);
        FLMotor.setPower(rotate + vertical + horizontal);
        BRMotor.setPower(vertical - rotate + horizontal);
        BLMotor.setPower(vertical + rotate - horizontal);

         */

         


    }

}
}

