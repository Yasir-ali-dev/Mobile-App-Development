import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker (context:Context, workerParameters: WorkerParameters) :Worker(context,workerParameters){
    override fun doWork(): Result {
        val username = inputData.getString("username") ?: return Result.failure()
        val password = inputData.getString("password")?: return Result.failure()
        Log.d("msg","$username $password")

        if(username == "sajid" && password =="123"){
            return Result.success()
        }else{
            return Result.failure()
        }
    }

}