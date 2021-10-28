package com.marking.cpuscheduling;

public class Prioruty{

    int x,i,j,size;

    int at[] = new int[100];
    int pp[] = new int[100];
    int bt[] = new int[100];
    int wt[] = new int[100];
    int ta[] = new int[100];


public void sort(int n, int ar[], int bs[], int pid[])
{
    size=n;
    at=ar;
    bt=bs;
    pp=pid;

    for(i=0;i<n-1;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(pp[i]>pp[j])
            {
                x=pp[i];
                pp[i]=pp[j];
                pp[j]=x;

                x=bt[i];
                bt[i]=bt[j];
                bt[j]=x;

                x=at[i];
                at[i]=at[j];
                at[j]=x;
            }
        }
    }
    wt[0]=0;
    ta[0]=bt[0];
    for(i=1;i<n;i++)
    {
        wt[i]=ta[i-1];
        ta[i]=wt[i]+bt[i];
    }

}

int[] waitingtime()
{
    return wt;
}
int[] turnaroundtime()
{
    return ta;
}

}



