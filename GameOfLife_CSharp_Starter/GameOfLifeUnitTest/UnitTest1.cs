using System;
using StarterCodingDojoGameOfLife;
using Microsoft.VisualStudio.TestTools.UnitTesting;


namespace GameOfLifeUnitTest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void Une_Cellule_Vivante_Avec_Moins_de_2_Voisines_Meurt()
        {
            //Arrange
            CelluleEtat cellule = CelluleEtat.Vivante;
            int nombreVoisin = 1;

            //Act
            CelluleEtat resultat = VieDuneCellule.NouvelleEtat(cellule, nombreVoisin);

            //Assert 
            Assert.AreEqual(CelluleEtat.Morte, resultat);
        }

        [TestMethod]
        public void Une_Cellule_Vivante___()
        {
            //Arrange 

            //Act

            //Assert

        }
    }
}

