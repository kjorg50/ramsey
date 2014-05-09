import java.util.*;

public class Chromosome
{
    int fitness;
    ColorMatrix C;
    private static final int RAMSEY_SIZE = 6;

    public Chromosome(ColorMatrix C)
    {
    this.C = C;
    this.fitness = 0;
    calcFitness(RAMSEY_SIZE);
    }

    /*
        I removed the clique count calculation out of getFitness(), because it
        is a very expensive computation. Now, the clique count will only be 
        calculated when each Chromosome is created or mutated. 
     */
    public void calcFitness(int n) //n-clique
    {
        /*
        *** counts the number of monochromatic cliques in the current chromosome
        ***
        *** only checks values above diagonal
        */
        int[] clique = new int[n]; // to hold the vertices we want to make a clique with
        int numVerts = C.getGraph().getVertices();
        for(int i=0; i<numVerts-n+1; i++)
        {
            for(int j=i+1; j<numVerts-n+2; j++)
            {
                for (int k=j+1; k<numVerts-n+3; k++) 
                {
                    if( C.getColor(i,j) == C.getColor(i,k) &&
                        C.getColor(i,j) == C.getColor(j,k))
                    {
                        for (int l=k+1;l < numVerts-n+4; l++) 
                        {
                            if( C.getColor(i,j) == C.getColor(i,l) &&
                                C.getColor(i,j) == C.getColor(j,l) &&
                                C.getColor(i,j) == C.getColor(k,l)) 
                            {
                                for (int m=l+1; m<numVerts-n+5; m++) 
                                {
                                    if ( C.getColor(i,j) == C.getColor(i,m) &&
                                         C.getColor(i,j) == C.getColor(j,m) &&
                                         C.getColor(i,j) == C.getColor(k,m) &&
                                         C.getColor(i,j) == C.getColor(l,m))
                                    {
                                        for (int inner=m+1; inner<numVerts-n+6; inner++) 
                                        {
                                            if(C.getColor(i,j) == 
                                                 C.getColor(i,inner) &&
                                               C.getColor(i,j) == 
                                                 C.getColor(j,inner) &&
                                               C.getColor(i,j) == 
                                                 C.getColor(k,inner) &&
                                               C.getColor(i,j) == 
                                                 C.getColor(l,inner) &&
                                               C.getColor(i,j) ==
                                                 C.getColor(m,inner))
                                            {
                                                this.fitness++;
                                            }
                                        }
                                    }   
                                }// end m loop
                            } 
                        }// end l loop
                    }

                }// end k loop

            }// end j loop
        }// end i loop   
    }

    public int getFitness() 
    {
    return this.fitness;
    }

    public ColorMatrix mutate()
    {
    //do some stuff to it
    return this.C;
    }
    
    public ColorMatrix getColorMatrix()
    {
    return this.C;
    }
    
}
