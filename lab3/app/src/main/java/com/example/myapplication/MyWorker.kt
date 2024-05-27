import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker (context:Context, workerParameters: WorkerParameters) :Worker(context,workerParameters){
    override fun doWork(): Result {
        var isImage =false;
        Log.d("msg","work done")

        if(isImage){
            return Result.success()
        }else{
            return Result.failure()
        }
    }

}