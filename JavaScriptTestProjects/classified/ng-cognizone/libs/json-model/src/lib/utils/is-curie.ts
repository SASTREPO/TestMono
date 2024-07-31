/**
 *
 * @deprecated Use `isCurie` from `@cognizone/lod` instead.
 */
export function isCurie(value: string): boolean {
  return !value.includes('://') && !value.startsWith('/');
}
