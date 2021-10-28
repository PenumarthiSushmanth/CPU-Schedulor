package com.marking.cpuscheduling;

public class LJFC2
{
    int p[] = new int[100];
    public void cal(int n,int[] at,int[] bt, int[] pid)
    {
        p=pid;
        int i=0,j=1;
        int temp=0;
        for(i=0;i<n-1;i++)
        {
            for(j=i+1;j<n;j++)
            {
                if(bt[i]<bt[j])
                {
                    temp=bt[i];
                    bt[i]=bt[j];
                    bt[j]=temp;

                    temp=at[i];
                    at[i]=at[j];
                    at[j]=temp;

                    temp=p[i];
                    p[i]=p[j];
                    p[j]=temp;
                }
            }
        }
    }
    int[] waitingtime(int n, int[] arrival, int[] burst)
    {
        int[] wt=new int[n];
        int[] compltime=new int[n];
        int i=1;
        compltime[0]=burst[0];
        wt[0]=0;
        for(i=1;i<n;i++)
        {
            compltime[i]=compltime[i-1]+burst[i]-arrival[i];
            wt[i]=compltime[i]-burst[i];
        }
        return wt;
    }

    int[] turnaroundtime(int n, int[] wt, int[] burst)
    {
        int[] tt=new int[n];
        int i=0;
        for(;i<n;i++)
        {
            tt[i]=wt[i]+burst[i];
        }
        return tt;
    }

    int[] processor()
    {
        return p;
    }
}