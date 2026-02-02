const Footer = async () => {
  const year = new Date().getFullYear();
  return (
    <footer
      className="footer mt-auto flex justify-around py-3 relative z-20 text-fnbg-purple font-bold"
      style={{ bottom: "0", width: "100%" }}
    >
      <div>
        Fabian Berger
        <br />
        Jenaer Straße 1<br />
        91058 Erlangen
      </div>
      <div className="my-auto text-center">© {year} - Fabian Berger</div>
    </footer>
  );
};

export default Footer;
