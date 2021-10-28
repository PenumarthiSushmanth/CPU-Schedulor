package com.marking.cpuscheduling;

public class LJFC
{
    int p[] = new int[10];
    int at[] = new int[10];
    int bt[] = new int[10];
    int wt[] = new int[10];
    int tat[] = new int[10];
    int temp, size, total=0;

    public void cal(int n, int at[], int bt[], int pid[])
    {
        size = n;
        p=pid;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(bt[i]< bt[j])
                {
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;

                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;

                    temp = at[i];
                    at[i] = at[j];
                    at[j] = temp;

                }
            }
        }

        wt[0] = 0;
        for(int i=1;i<n;i++)
        {
            wt[i] = wt[i-1]+bt[i-1];

        }
        for(int i=1;i<n;i++)
        {
            tat[i]=wt[i]+bt[i];
        }
    }
    int [] waitingtime()
    {
        return wt;
    }
    int [] turnaroundtime()
    {
        return tat;
    }
    int [] processor()
    {
        return p;
    }


}

