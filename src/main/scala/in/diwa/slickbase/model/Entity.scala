package in.diwa.slickbase.model

trait Entity[E <: Entity[E]] {
  // self-typing to E to force withId to return this type
  self: E =>

  def id: Option[Long]

  // todo: use scala reflection (or macros) to impl this method in a generic way
  def withId(id: Long): E

}
