package com.gussoft.patrones.comportamiento.iterator;

public class CubeList implements GList {

  private Cube[] cubes;

  public CubeList(Cube[] cubes) {
    this.cubes = cubes;
  }

  @Override
  public Iterator iterator() {
    return new CubeIterator(cubes);
  }
}
