package app.wakayama.harusame.renda

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //タップした数の変数
        var tapCount = 0

        //残り時間の設定
        var second = 10

        val timer:CountDownTimer = object :CountDownTimer(10000,1000){
            override fun onFinish() {
                //スタートボタンを表示する
                startButton.isVisible = true
//                tapButton.setBackgroundResource(R.drawable.background_rounded_circle_glay)
                tapButton.setBackgroundColor(Color.rgb(155,155,155))
                second = 10
                tapCount = 0
            }

            override fun onTick(millisUntilFinished: Long) {
                second = second - 1
                secondText.text = second.toString()
            }
        }

        startButton.setOnClickListener{
            countText.text = tapCount.toString()
            //スタートボタンを隠す
            startButton.isVisible = false
            timer.start()
        }

        tapButton.setOnClickListener {
            if(second < 10){
                tapCount = tapCount + 1
                countText.text = tapCount.toString()
            }
        }
    }
}