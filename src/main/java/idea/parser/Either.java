package idea.parser;

public abstract class Either<L, R> {
    static public <L, R> Either<L, R> left(L l) {
        return new LeftProjection<L, R>(l);
    }

    static public <L, R> Either<L, R> right(R r) {
        return new RightProjection<L, R>(r);
    }

    public abstract boolean isLeft();

    public abstract boolean isRight();

    public abstract L left();

    public abstract R right();

    private static class LeftProjection<L, R> extends Either<L, R> {
        private final L l;

        public LeftProjection(L l) {
            this.l = l;
        }

        @Override
        public boolean isLeft() {
            return true;
        }

        @Override
        public boolean isRight() {
            return false;
        }

        @Override
        public L left() {
            return l;
        }

        @Override
        public R right() {
            throw new NullPointerException("No right on a left projection");
        }
    }

    private static class RightProjection<L, R> extends Either<L, R> {
        private final R r;

        public RightProjection(R r) {
            this.r = r;
        }

        @Override
        public boolean isLeft() {
            return false;
        }

        @Override
        public boolean isRight() {
            return true;
        }

        @Override
        public L left() {
            throw new NullPointerException("No left on a right projection");
        }

        @Override
        public R right() {
            return r;
        }
    }
}
