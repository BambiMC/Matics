import styles from './Triangle.module.css';

const Triangles = () => {
    return (
        <div className={styles.container_row}>
            <div style={{ gridColumn: '1', gridRow: '1' }}>
                <div className={styles.triangleOrange}></div>
            </div>
            <div style={{ gridColumn: '2', gridRow: '1' }}>
                <div className={styles.trianglePurple}></div>
            </div>
            <div style={{ gridColumn: '2', gridRow: '1' }}>
                <div className={styles.triangleOrange}></div>
            </div>
            <div style={{ gridColumn: '1', gridRow: '1' }}>
                <div className={styles.trianglePurple}></div>
            </div>
            <div style={{ gridColumn: '3', gridRow: '1' }}>
                <div className={styles.triangleOrange}></div>
            </div>
            <div style={{ gridColumn: '4', gridRow: '1' }}>
                <div className={styles.trianglePurple}></div>
            </div>
            <div style={{ gridColumn: '4', gridRow: '1' }}>
                <div className={styles.triangleOrange}></div>
            </div>
            <div style={{ gridColumn: '3', gridRow: '1' }}>
                <div className={styles.trianglePurple}></div>
            </div>
            <div style={{ gridColumn: '1', gridRow: '2' }}>
                <div className={styles.triangleOrange}></div>
            </div>
            <div style={{ gridColumn: '2', gridRow: '2' }}>
                <div className={styles.trianglePurple}></div>
            </div>
            <div style={{ gridColumn: '2', gridRow: '2' }}>
                <div className={styles.triangleOrange}></div>
            </div>
            <div style={{ gridColumn: '1', gridRow: '2' }}>
                <div className={styles.trianglePurple}></div>
            </div>
            <div style={{ gridColumn: '3', gridRow: '2' }}>
                <div className={styles.triangleOrange}></div>
            </div>
            <div style={{ gridColumn: '4', gridRow: '2' }}>
                <div className={styles.trianglePurple}></div>
            </div>
            <div style={{ gridColumn: '4', gridRow: '2' }}>
                <div className={styles.triangleOrange}></div>
            </div>
            <div style={{ gridColumn: '3', gridRow: '2' }}>
                <div className={styles.trianglePurple}></div>
            </div>
        </div>
    );
};

export default Triangles;