package org.emall.cn.common.arithmetic;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Description 合并框架Fork/join
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2017/2/6
 */
public class CountTask extends RecursiveTask<Integer>{
    private static final int THRESHOLD=2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     */
    @Override
    protected Integer compute() {
        int sum=0;
        boolean canCompute=(end-start)<=THRESHOLD;
        if(canCompute){
            for (int i = start; i <=end ; i++) {
                sum+=i;
            }
        }else{
            int middle=(start+end)/2;
            CountTask leftTask=new CountTask(start,middle);
            CountTask rightTask=new CountTask(middle+1,end);
            leftTask.fork();
            rightTask.fork();
            //等待子任务完成后，合并结果
            int leftResult=leftTask.join();
            int rightResult=rightTask.join();
            sum=rightResult+leftResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        CountTask task=new CountTask(1,8);
        Future<Integer> result=forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        }catch (InterruptedException e){

        } catch (java.util.concurrent.ExecutionException e) {
            e.printStackTrace();
        }
    }
}
