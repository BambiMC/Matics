const Footer = () => {
  return (
    <footer className="footer mt-auto flex justify-around py-3 relative z-20" style={{ position: 'fixed', bottom: '0', width: '100%' }}>
      <div>
        Fabian Berger<br />
        Ratiborer Straße 2<br />
        91058 Erlangen
      </div>
      <div className="my-auto text-center">
        © 2023 - Fabian Berger
      </div>
    </footer>
  );
};

export default Footer;
