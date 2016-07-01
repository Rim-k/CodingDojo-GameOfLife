using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StarterCodingDojoGameOfLife
{
    public enum CelluleEtat
    {
        Vivante,
        Morte
    }

    public class VieDuneCellule
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Coding Dojo Game Of Life");

            Console.ReadLine();
        }

        public static CelluleEtat NouvelleEtat(CelluleEtat cellule, int nbVoisin)
        {
                return CelluleEtat.Morte;
        }

    }
}
