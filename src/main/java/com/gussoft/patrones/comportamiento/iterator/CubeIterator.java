package com.gussoft.patrones.comportamiento.iterator;

public class CubeIterator implements Iterator {

  private Cube[] cubes;
  private int position;

  public CubeIterator(Cube[] cubes) {
    this.cubes = cubes;
    position = 0;
  }

  @Override
  public boolean hasNext() {
    if (position >= cubes.length) {
      return false;
    }
    return true;
  }

  @Override
  public Object next() {
    return cubes[position++];
  }

  @Override
  public Object currentItem() {
    return cubes[position];
  }
}
