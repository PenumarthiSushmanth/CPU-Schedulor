package com.marking.cpuscheduling;

public class Prioruty2{

    int x,size,i;

    int p[] = new int[100];
    int pp[] = new int[100];
    int bt[] = new int[100];
    int w[] = new int[100];
    int t[] = new int[100];
    int at[] = new int[100];

    public void sort(int n, int at[], int bt[], int pid[])
    {
        size=n;
        this.at=at;
        this.bt=bt;
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
                    x=p[i];
                    p[i]=p[j];
                    p[j]=x;
                }
            }
        }
        w[0]=0;
        t[0]=bt[0];
        for(i=1;i<n;i++)
        {
            w[i]=t[i-1]-at[i];;

            t[i]=w[i]+bt[i];
        }
    }
    int [] waitingtime()
    {
        return w;
    }
    int [] turnaroundtime()
    {
        return t;
    }
}