import java.util.*;

public class Population
{
    ArrayList<Chromosome> pop;
    public Population(int size, int graphsize)
    {
	pop = new ArrayList<Chromosome>();
	for(int i=0; i<size; i++)
	    {
		//make a new graph
		AdjMatrixGraph G = new AdjMatrixGraph(graphsize);
		//then a new coloring for that graph
		ColorMatrix C = new ColorMatrix(G);
		//then add that coloring to the pop
		pop.add(new Chromosome(C));
	    }
    }
    //blank constructor to use for manual inserting (from file)
    public Population()
    {
	pop = new ArrayList<Chromosome>();
    }

    //makes a pop from a pre formed list of chromosomes
    public Population(ArrayList<Chromosome> list)
    {
	//hopefully this copies everything over, might need to make a manual move
	System.out.println(list);
	pop = list;
    }

    public int getSize()
    {
	return pop.size();
    }
    
    public Chromosome getWorst()
    {
	Chromosome worst = pop.get(0);
	for(Chromosome c:pop)
	    {
		if(c.getFitness()>worst.getFitness())
		    worst = c;
	    }
	return worst;
    }

    public int getWorstPosition()
    {
	int worst = 0;
	for(int i=0; i<pop.size(); i++)
	    {
		if(pop.get(i).getFitness()>pop.get(worst).getFitness())
		    worst = i;
	    }
	return worst;
    }

    public Chromosome getBest()
    {
	Chromosome best = pop.get(0);
	for(Chromosome c:pop)
	    {
		if(c.getFitness()<best.getFitness())
		    best = c;
	    }
	return best;
    }

    public int getBestPosition()
    {
	int best = 0;
	for(int i=0; i<pop.size(); i++)
	    {
		if(pop.get(i).getFitness()<pop.get(best).getFitness())
		    best = i;
	    }
	return best;
    }


    @Override
    public String toString()
    {
	int i = 0;
	String p="";
	int termsPerRow = 25;
	for(Chromosome c:pop)
	    {
		//p+="Fitness for graph "+i+": "+c.getFitness();
		p+=c.getFitness()+"  ";
		termsPerRow--;
		//if(c.getFitness()==0)
		    //    c.getColorMatrix().printColoring();
		if(termsPerRow==0)
		    {
			p+="\n";
			termsPerRow=25;
		    }
		i++;
	    }
	return p;
    }

    public Chromosome getChromosome(int index)
    {
	return pop.get(index);
    }
    public void addChromosome(int index, Chromosome c)
    {
	//if element at index exists replace it
	if(pop.get(index) != null)
	    pop.set(index, c);
	//otherwise just add it
	else
	    pop.add(c);
    }
    public void addChromosome(Chromosome c)
    {
	pop.add(c);
    }
    public ArrayList<Chromosome> getPop()
    {
	return this.pop;
    }
}
